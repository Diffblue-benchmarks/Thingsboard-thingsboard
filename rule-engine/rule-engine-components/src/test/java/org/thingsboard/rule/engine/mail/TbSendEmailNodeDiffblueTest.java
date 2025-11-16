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
package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.HashMap;
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
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbEmail;
import org.thingsboard.rule.engine.api.TbEmail.TbEmailBuilder;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbSendEmailNodeDiffblueTest {
  @InjectMocks private TbSendEmailNode tbSendEmailNode;

  @Mock private TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration;

  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowIllegalStateException() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new IllegalStateException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws JsonProcessingException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() throws JsonProcessingException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to(null)
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenCallsTellFailure() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code false}.
   *   <li>Then calls {@link TbMsg#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOf(TbMsgType) return 'false'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOfReturnFalse_thenCallsGetType() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getType()).thenReturn("Type");

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getType();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given IllegalStateException(); when TbMsg getData() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenIllegalStateException_whenTbMsgGetDataThrowIllegalStateException() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new IllegalStateException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given IllegalStateException(); when TbMsg isTypeOf(TbMsgType) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenIllegalStateException_whenTbMsgIsTypeOfThrowIllegalStateException() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new IllegalStateException());

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link MailService} {@link MailService#send(TenantId, CustomerId, TbEmail)} does
   *       nothing.
   *   <li>Then calls {@link MailService#send(TenantId, CustomerId, TbEmail)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given MailService send(TenantId, CustomerId, TbEmail) does nothing; then calls send(TenantId, CustomerId, TbEmail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenMailServiceSendDoesNothing_thenCallsSend()
      throws JsonProcessingException, ThingsboardException {
    // Arrange
    when(tbSendEmailNodeConfiguration.isUseSystemSmtpSettings()).thenReturn(true);

    MailService mailService = mock(MailService.class);
    doNothing()
        .when(mailService)
        .send(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<TbEmail>any());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getMailService(anyBoolean())).thenReturn(mailService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getMailExecutor()).thenReturn(new TestDbCallbackExecutor());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(mailService).send(isA(TenantId.class), isA(CustomerId.class), isA(TbEmail.class));
    verify(ctx).getMailExecutor();
    verify(ctx).getMailService(true);
    verify(ctx).getTenantId();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSendEmailNodeConfiguration).isUseSystemSmtpSettings();
    verify(msg).getCustomerId();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link MailService} {@link MailService#send(TenantId, CustomerId, TbEmail)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link MailService#send(TenantId, CustomerId, TbEmail)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given MailService send(TenantId, CustomerId, TbEmail) throw IllegalStateException(); then calls send(TenantId, CustomerId, TbEmail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenMailServiceSendThrowIllegalStateException_thenCallsSend()
      throws JsonProcessingException, ThingsboardException {
    // Arrange
    when(tbSendEmailNodeConfiguration.isUseSystemSmtpSettings()).thenReturn(true);

    MailService mailService = mock(MailService.class);
    doThrow(new IllegalStateException())
        .when(mailService)
        .send(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<TbEmail>any());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getMailService(anyBoolean())).thenReturn(mailService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getMailExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(mailService).send(isA(TenantId.class), isA(CustomerId.class), isA(TbEmail.class));
    verify(ctx).getMailExecutor();
    verify(ctx).getMailService(true);
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendEmailNodeConfiguration).isUseSystemSmtpSettings();
    verify(msg).getCustomerId();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link MailService}.
   *   <li>When {@link TbMsg} {@link TbMsg#getCustomerId()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given MailService; when TbMsg getCustomerId() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenMailService_whenTbMsgGetCustomerIdThrowIllegalStateException()
      throws JsonProcessingException {
    // Arrange
    when(tbSendEmailNodeConfiguration.isUseSystemSmtpSettings()).thenReturn(false);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getMailService(anyBoolean())).thenReturn(mock(MailService.class));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getMailExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenThrow(new IllegalStateException());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getMailExecutor();
    verify(ctx).getMailService(false);
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendEmailNodeConfiguration).isUseSystemSmtpSettings();
    verify(msg).getCustomerId();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getMailExecutor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getMailExecutor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbContextGetMailExecutorReturnNull() throws JsonProcessingException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getMailExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getMailExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTestDbCallbackExecutor() throws JsonProcessingException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getMailExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getMailExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getMailExecutor()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext getMailExecutor() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextGetMailExecutorThrowIllegalStateException()
      throws JsonProcessingException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getMailExecutor()).thenThrow(new IllegalStateException());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    String writeValueAsStringResult =
        jsonMapper.writeValueAsString(
            htmlResult
                .images(new HashMap<>())
                .subject("Hello from the Dreaming Spires")
                .to("alice.liddell@example.org")
                .build());
    when(msg.getData()).thenReturn(writeValueAsStringResult);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getMailExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.SEND_EMAIL);
  }
}
