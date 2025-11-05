package org.thingsboard.rule.engine.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.api.sms.SmsSender;
import org.thingsboard.rule.engine.api.sms.exception.SmsException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbSendSmsNodeDiffblueTest {
  @Mock private SmsSender smsSender;

  @InjectMocks private TbSendSmsNode tbSendSmsNode;

  @Mock private TbSendSmsNodeConfiguration tbSendSmsNodeConfiguration;

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
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
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
  void testOnMsg2() {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenThrow(new RuntimeException());
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
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
  void testOnMsg3() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "\\.", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
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
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbContext} {@link TbContext#getSmsService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); when TbContext getSmsService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_whenTbContextGetSmsServiceThrowRuntimeException() {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsService()).thenThrow(new RuntimeException());
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
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
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(smsSender).sendSms("42", "Sms Message Template");
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
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
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(smsSender).sendSms("42", "Sms Message Template");
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
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
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(smsService)
        .sendSms(isA(TenantId.class), isNull(), isA(String[].class), eq("Sms Message Template"));
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SmsService} {@link SmsService#sendSms(TenantId, CustomerId, String[],
   *       String)} throw {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SmsService#sendSms(TenantId, CustomerId, String[], String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SmsService sendSms(TenantId, CustomerId, String[], String) throw RuntimeException(); then calls sendSms(TenantId, CustomerId, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSmsServiceSendSmsThrowRuntimeException_thenCallsSendSms()
      throws ThingsboardException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(true);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("Sms Message Template");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    SmsService smsService = mock(SmsService.class);
    doThrow(new RuntimeException())
        .when(smsService)
        .sendSms(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<String[]>any(),
            Mockito.<String>any());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsService()).thenReturn(smsService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(smsService)
        .sendSms(isA(TenantId.class), isNull(), isA(String[].class), eq("Sms Message Template"));
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSendSmsNodeConfiguration} {@link
   *       TbSendSmsNodeConfiguration#getSmsMessageTemplate()} return {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSendSmsNodeConfiguration getSmsMessageTemplate() return '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSendSmsNodeConfigurationGetSmsMessageTemplateReturnUu()
      throws SmsException {
    // Arrange
    when(tbSendSmsNodeConfiguration.isUseSystemSmsSettings()).thenReturn(false);
    when(tbSendSmsNodeConfiguration.getSmsMessageTemplate()).thenReturn("$[UU]");
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");
    when(smsSender.sendSms(Mockito.<String>any(), Mockito.<String>any())).thenReturn(3);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(smsSender).sendSms("42", "$[UU]");
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSendSmsNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSendSmsNode (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSendSmsNode_thenCallsTellFailure() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenNull_thenCallsTellFailure() {
    // Arrange
    when(tbSendSmsNodeConfiguration.getNumbersToTemplate()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendSmsNode.onMsg(ctx, null);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellSuccess(TbMsg) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendSmsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellSuccessThrowRuntimeException() throws ThingsboardException {
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
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendSmsNode.onMsg(ctx, msg);

    // Assert
    verify(smsService)
        .sendSms(isA(TenantId.class), isNull(), isA(String[].class), eq("Sms Message Template"));
    verify(ctx).getSmsExecutor();
    verify(ctx).getSmsService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSendSmsNodeConfiguration).getNumbersToTemplate();
    verify(tbSendSmsNodeConfiguration).getSmsMessageTemplate();
    verify(tbSendSmsNodeConfiguration).isUseSystemSmsSettings();
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
