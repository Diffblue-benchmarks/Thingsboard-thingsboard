package org.thingsboard.rule.engine.aws.sqs;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
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
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.aws.sqs.TbSqsNodeConfiguration.QueueType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbSqsNodeDiffblueTest {
  @Mock private AmazonSQS amazonSQS;

  @InjectMocks private TbSqsNode tbSqsNode;

  @Mock private TbSqsNodeConfiguration tbSqsNodeConfiguration;

  /**
   * Test {@link TbSqsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbSqsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbSqsNode tbSqsNode = new TbSqsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSqsNodeConfiguration tbSqsNodeConfiguration = mock(TbSqsNodeConfiguration.class);
    when(tbSqsNodeConfiguration.getRegion())
        .thenReturn("org.thingsboard.rule.engine.aws.sqs.TbSqsNodeConfiguration");
    when(tbSqsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSqsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSqsNodeConfiguration));

    // Act
    tbSqsNode.init(ctx, configuration);

    // Assert
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSqsNodeConfiguration).getAccessKeyId();
    verify(tbSqsNodeConfiguration).getRegion();
    verify(tbSqsNodeConfiguration).getSecretAccessKey();
  }

  /**
   * Test {@link TbSqsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link TbSqsNodeConfiguration} {@link TbSqsNodeConfiguration#getRegion()} return
   *       {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given TbSqsNodeConfiguration getRegion() return 'us-east-2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenTbSqsNodeConfigurationGetRegionReturnUsEast2()
      throws TbNodeException {
    // Arrange
    TbSqsNode tbSqsNode = new TbSqsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSqsNodeConfiguration tbSqsNodeConfiguration = mock(TbSqsNodeConfiguration.class);
    when(tbSqsNodeConfiguration.getRegion()).thenReturn("us-east-2");
    when(tbSqsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSqsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSqsNodeConfiguration));

    // Act
    tbSqsNode.init(ctx, configuration);

    // Assert
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSqsNodeConfiguration).getAccessKeyId();
    verify(tbSqsNodeConfiguration).getRegion();
    verify(tbSqsNodeConfiguration).getSecretAccessKey();
  }

  /**
   * Test {@link TbSqsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbSqsNode tbSqsNode = new TbSqsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSqsNodeConfiguration tbSqsNodeConfiguration = mock(TbSqsNodeConfiguration.class);
    when(tbSqsNodeConfiguration.getRegion()).thenThrow(new RuntimeException());
    when(tbSqsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSqsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSqsNodeConfiguration));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbSqsNode.init(ctx, configuration));
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSqsNodeConfiguration).getAccessKeyId();
    verify(tbSqsNodeConfiguration).getRegion();
    verify(tbSqsNodeConfiguration).getSecretAccessKey();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMD5OfMessageBody("27c7cf400229103e00c6d8830029e29b");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMD5OfMessageAttributes("27c7cf400229103e00c6d8830029e29b");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg3() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMD5OfMessageBody("27c7cf400229103e00c6d8830029e29b");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    sendMessageResult.setMessageId("$[UU]");
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is empty string.
   *   <li>Then calls {@link TbSqsNodeConfiguration#getDelaySeconds()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashMap() empty string is empty string; then calls getDelaySeconds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashMapEmptyStringIsEmptyString_thenCallsGetDelaySeconds() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("", "");
    stringStringMap.put("messageId", "$[UU]");
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(stringStringMap);
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMD5OfMessageBody("27c7cf400229103e00c6d8830029e29b");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    sendMessageResult.setMessageId("$[UU]");
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code requestId} is {@code messageId}.
   *   <li>Then calls {@link TbSqsNodeConfiguration#getDelaySeconds()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashMap() 'requestId' is 'messageId'; then calls getDelaySeconds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashMapRequestIdIsMessageId_thenCallsGetDelaySeconds() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("requestId", "messageId");
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(stringStringMap);
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SendMessageResult} (default constructor) MD5OfMessageBody is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SendMessageResult (default constructor) MD5OfMessageBody is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSendMessageResultMD5OfMessageBodyIsEmptyString() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMD5OfMessageBody("");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    sendMessageResult.setMessageId("$[UU]");
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SendMessageResult} (default constructor) MessageId is {@code 42}.
   *   <li>Then calls {@link TbSqsNodeConfiguration#getDelaySeconds()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SendMessageResult (default constructor) MessageId is '42'; then calls getDelaySeconds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSendMessageResultMessageIdIs42_thenCallsGetDelaySeconds() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setMessageId("42");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link SendMessageResult} (default constructor) SequenceNumber is {@code 42}.
   *   <li>Then calls {@link TbSqsNodeConfiguration#getDelaySeconds()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given SendMessageResult (default constructor) SequenceNumber is '42'; then calls getDelaySeconds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenSendMessageResultSequenceNumberIs42_thenCallsGetDelaySeconds() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSequenceNumber("42");
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSqsNodeConfiguration} {@link TbSqsNodeConfiguration#getQueueType()} return
   *       {@code FIFO}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSqsNodeConfiguration getQueueType() return 'FIFO'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSqsNodeConfigurationGetQueueTypeReturnFifo() {
    // Arrange
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.FIFO);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    sendMessageResult.setMessageId("$[UU]");
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSqsNodeConfiguration} {@link TbSqsNodeConfiguration#getQueueUrlPattern()}
   *       return {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSqsNodeConfiguration getQueueUrlPattern() return '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSqsNodeConfigurationGetQueueUrlPatternReturnUu() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("$[UU]");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbSqsNodeConfiguration#getDelaySeconds()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls getDelaySeconds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsGetDelaySeconds() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link CustomerId#CustomerId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when CustomerId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenCustomerIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(tbSqsNodeConfiguration.getDelaySeconds()).thenReturn(1);
    when(tbSqsNodeConfiguration.getMessageAttributes()).thenReturn(new HashMap<>());
    when(tbSqsNodeConfiguration.getQueueType()).thenReturn(QueueType.STANDARD);
    when(tbSqsNodeConfiguration.getQueueUrlPattern()).thenReturn("https://example.org/example");

    SendMessageResult sendMessageResult = new SendMessageResult();
    sendMessageResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    sendMessageResult.setMessageId("$[UU]");
    when(amazonSQS.sendMessage(Mockito.<SendMessageRequest>any())).thenReturn(sendMessageResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSqsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSQS).sendMessage(isA(SendMessageRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSqsNodeConfiguration).getDelaySeconds();
    verify(tbSqsNodeConfiguration).getMessageAttributes();
    verify(tbSqsNodeConfiguration).getQueueType();
    verify(tbSqsNodeConfiguration).getQueueUrlPattern();
  }

  /**
   * Test {@link TbSqsNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link AmazonSQS} {@link AmazonSQS#shutdown()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given AmazonSQS shutdown() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.destroy()"})
  void testDestroy_givenAmazonSQSShutdownDoesNothing() {
    // Arrange
    doNothing().when(amazonSQS).shutdown();

    // Act
    tbSqsNode.destroy();

    // Assert
    verify(amazonSQS).shutdown();
  }

  /**
   * Test {@link TbSqsNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link AmazonSQS} {@link AmazonSQS#shutdown()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given AmazonSQS shutdown() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqsNode.destroy()"})
  void testDestroy_givenAmazonSQSShutdownThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(amazonSQS).shutdown();

    // Act
    tbSqsNode.destroy();

    // Assert
    verify(amazonSQS).shutdown();
  }
}
