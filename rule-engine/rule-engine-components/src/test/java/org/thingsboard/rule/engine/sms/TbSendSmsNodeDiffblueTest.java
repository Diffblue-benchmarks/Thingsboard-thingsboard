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
package org.thingsboard.rule.engine.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.api.sms.SmsSender;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.rule.engine.api.sms.exception.SmsException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sms.config.SmsProviderConfiguration;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbSendSmsNodeDiffblueTest {
  @Mock private SmsSender smsSender;

  @InjectMocks private TbSendSmsNode tbSendSmsNode;

  @Mock private TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration;

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    when(smsSenderFactory.createSmsSender(Mockito.<SmsProviderConfiguration>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    when(ctx.getSmsSenderFactory()).thenReturn(smsSenderFactory);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbSendSmsNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbSendSmsNodeConfiguration()))));
    verify(ctx).getSmsSenderFactory();
    verify(ctx).isExternalNodeForceAck();
    verify(smsSenderFactory).createSmsSender(isNull());
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration2() throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration = new TbSendSmsNodeConfiguration();
    tbSendSmsNodeConfiguration.setUseSystemSmsSettings(true);

    // Act
    tbSendSmsNode.init(ctx, new TbNodeConfiguration(new POJONode(tbSendSmsNodeConfiguration)));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link SmsSenderFactory} {@link
   *       SmsSenderFactory#createSmsSender(SmsProviderConfiguration)} return {@link SmsSender}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given SmsSenderFactory createSmsSender(SmsProviderConfiguration) return SmsSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenSmsSenderFactoryCreateSmsSenderReturnSmsSender()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    when(smsSenderFactory.createSmsSender(Mockito.<SmsProviderConfiguration>any()))
        .thenReturn(mock(SmsSender.class));

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    when(ctx.getSmsSenderFactory()).thenReturn(smsSenderFactory);

    // Act
    tbSendSmsNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbSendSmsNodeConfiguration())));

    // Assert
    verify(ctx).getSmsSenderFactory();
    verify(ctx).isExternalNodeForceAck();
    verify(smsSenderFactory).createSmsSender(isNull());
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code A}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'true'; when 'A'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenTrue_whenA_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    BinaryNode data = new BinaryNode(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode data = new ArrayNode(nf);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is three.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is three; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsThree_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(new POJONode(3))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsValueOfTen()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenThrow(new RuntimeException());
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenCallsGetData() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString_thenCallsGetData() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getSmsExecutor()} return {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getSmsExecutor() return 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbContextGetSmsExecutorReturnNull_thenCallsTellFailure() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendSmsNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaData()} return {@code null}.
   *   <li>Then calls {@link TbSendSmsNodeConfiguration#getNumbersToTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbMsg getMetaData() return 'null'; then calls getNumbersToTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbMsgGetMetaDataReturnNull_thenCallsGetNumbersToTemplate() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(null);

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); when TbMsg getData() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_whenTbMsgGetDataThrowRuntimeException() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); when TbMsg getMetaData() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_whenTbMsgGetMetaDataThrowRuntimeException() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenThrow(new RuntimeException());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SmsSender} {@link SmsSender#sendSms(String, String)} return three.
   *   <li>Then calls {@link SmsSender#sendSms(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SmsSender sendSms(String, String) return three; then calls sendSms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSmsSenderSendSmsReturnThree_thenCallsSendSms() throws SmsException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(false);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");
    when(smsSender.sendSms(Mockito.<String>any(), Mockito.<String>any())).thenReturn(3);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(smsSender).sendSms("42", "Sms Message Template");
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SmsSender} {@link SmsSender#sendSms(String, String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SmsSender#sendSms(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SmsSender sendSms(String, String) throw RuntimeException(); then calls sendSms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSmsSenderSendSmsThrowRuntimeException_thenCallsSendSms() throws SmsException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(false);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");
    when(smsSender.sendSms(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(smsSender).sendSms("42", "Sms Message Template");
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SmsService} {@link SmsService#sendSms(TenantId, CustomerId, String[],
   *       String)} does nothing.
   *   <li>Then calls {@link SmsService#sendSms(TenantId, CustomerId, String[], String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SmsService sendSms(TenantId, CustomerId, String[], String) does nothing; then calls sendSms(TenantId, CustomerId, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSmsServiceSendSmsDoesNothing_thenCallsSendSms() throws ThingsboardException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    SmsService smsService = mock(SmsService.class);
    doNothing()
        .when(smsService)
        .sendSms(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<String[]>any(),
            Mockito.<String>any());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getSmsService()).thenReturn(smsService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(smsService)
        .sendSms(
            isA(TenantId.class),
            isA(CustomerId.class),
            isA(String[].class),
            eq("Sms Message Template"));
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg).getCustomerId();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SmsService}.
   *   <li>When {@link TbMsg} {@link TbMsg#getCustomerId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SmsService; when TbMsg getCustomerId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSmsService_whenTbMsgGetCustomerIdThrowRuntimeException() {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsService()).thenReturn(mock(SmsService.class));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenThrow(new RuntimeException());
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg).getCustomerId();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Failed to process pattern!} is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value 'Failed to process pattern!' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueFailedToProcessPatternIs42() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Failed to process pattern!", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSendSmsNode} (default constructor).
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSendSmsNode (default constructor); when TbMsg; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSendSmsNode_whenTbMsg_thenCallsTellFailure() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendSmsNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenThrowRuntimeException() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenThrow(new RuntimeException());
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSendSmsNode.onMsg(ctx, mock(TbMsg.class)));
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getSmsService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbContext#getSmsService()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext getSmsService() throw RuntimeException(); then calls getSmsService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextGetSmsServiceThrowRuntimeException_thenCallsGetSmsService() {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsService()).thenThrow(new RuntimeException());
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SmsService#sendSms(TenantId, CustomerId, String[], String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellSuccess(TbMsg) throw RuntimeException(); then calls sendSms(TenantId, CustomerId, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellSuccessThrowRuntimeException_thenCallsSendSms()
      throws ThingsboardException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    SmsService smsService = mock(SmsService.class);
    doNothing()
        .when(smsService)
        .sendSms(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<String[]>any(),
            Mockito.<String>any());

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException()).when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getSmsService()).thenReturn(smsService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(smsService)
        .sendSms(
            isA(TenantId.class),
            isA(CustomerId.class),
            isA(String[].class),
            eq("Sms Message Template"));
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
    verify(msg).getCustomerId();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbSendSmsNode#destroy()}.
   *
   * <p>Method under test: {@link TbSendSmsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.destroy()"})
  void testDestroy() {
    // Arrange
    doNothing().when(smsSender).destroy();

    // Act
    tbSendSmsNode.destroy();

    // Assert
    verify(smsSender).destroy();
  }
}
