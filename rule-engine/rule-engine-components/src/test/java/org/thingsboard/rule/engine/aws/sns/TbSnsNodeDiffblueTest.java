package org.thingsboard.rule.engine.aws.sns;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbSnsNodeDiffblueTest {
  @Mock private AmazonSNS amazonSNS;

  @InjectMocks private TbSnsNode tbSnsNode;

  @Mock private TbSnsNodeConfiguration tbSnsNodeConfiguration;

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link TbSnsNodeConfiguration} {@link TbSnsNodeConfiguration#getRegion()} return
   *       {@code +}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given TbSnsNodeConfiguration getRegion() return '+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenTbSnsNodeConfigurationGetRegionReturnPlusSign()
      throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSnsNodeConfiguration tbSnsNodeConfiguration = mock(TbSnsNodeConfiguration.class);
    when(tbSnsNodeConfiguration.getRegion()).thenReturn("+");
    when(tbSnsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSnsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSnsNodeConfiguration));

    // Act
    tbSnsNode.init(ctx, configuration);

    // Assert
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSnsNodeConfiguration).getAccessKeyId();
    verify(tbSnsNodeConfiguration).getRegion();
    verify(tbSnsNodeConfiguration).getSecretAccessKey();
  }

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link TbSnsNodeConfiguration} {@link TbSnsNodeConfiguration#getRegion()} return
   *       {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given TbSnsNodeConfiguration getRegion() return 'us-east-2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenTbSnsNodeConfigurationGetRegionReturnUsEast2()
      throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSnsNodeConfiguration tbSnsNodeConfiguration = mock(TbSnsNodeConfiguration.class);
    when(tbSnsNodeConfiguration.getRegion()).thenReturn("us-east-2");
    when(tbSnsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSnsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSnsNodeConfiguration));

    // Act
    tbSnsNode.init(ctx, configuration);

    // Assert
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSnsNodeConfiguration).getAccessKeyId();
    verify(tbSnsNodeConfiguration).getRegion();
    verify(tbSnsNodeConfiguration).getSecretAccessKey();
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

    TbSnsNodeConfiguration tbSnsNodeConfiguration = mock(TbSnsNodeConfiguration.class);
    when(tbSnsNodeConfiguration.getRegion()).thenThrow(new RuntimeException());
    when(tbSnsNodeConfiguration.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(tbSnsNodeConfiguration.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbSnsNodeConfiguration));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbSnsNode.init(ctx, configuration));
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(tbSnsNodeConfiguration).getAccessKeyId();
    verify(tbSnsNodeConfiguration).getRegion();
    verify(tbSnsNodeConfiguration).getSecretAccessKey();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link PublishResult} (default constructor) MessageId is {@code 42}.
   *   <li>Then calls {@link AmazonSNS#publish(PublishRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given PublishResult (default constructor) MessageId is '42'; then calls publish(PublishRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenPublishResultMessageIdIs42_thenCallsPublish() {
    // Arrange
    when(tbSnsNodeConfiguration.getTopicArnPattern()).thenReturn("Topic Arn Pattern");

    PublishResult publishResult = new PublishResult();
    publishResult.setMessageId("42");
    publishResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSNS.publish(Mockito.<PublishRequest>any())).thenReturn(publishResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSNS).publish(isA(PublishRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSnsNodeConfiguration).getTopicArnPattern();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link PublishResult} (default constructor) MessageId is {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given PublishResult (default constructor) MessageId is '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenPublishResultMessageIdIsUu() {
    // Arrange
    when(tbSnsNodeConfiguration.getTopicArnPattern()).thenReturn("Topic Arn Pattern");

    PublishResult publishResult = new PublishResult();
    publishResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    publishResult.setMessageId("$[UU]");
    when(amazonSNS.publish(Mockito.<PublishRequest>any())).thenReturn(publishResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSNS).publish(isA(PublishRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSnsNodeConfiguration).getTopicArnPattern();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSnsNodeConfiguration} {@link TbSnsNodeConfiguration#getTopicArnPattern()}
   *       return {@code $[UU]}.
   *   <li>Then calls {@link AmazonSNS#publish(PublishRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSnsNodeConfiguration getTopicArnPattern() return '$[UU]'; then calls publish(PublishRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSnsNodeConfigurationGetTopicArnPatternReturnUu_thenCallsPublish() {
    // Arrange
    when(tbSnsNodeConfiguration.getTopicArnPattern()).thenReturn("$[UU]");

    PublishResult publishResult = new PublishResult();
    publishResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSNS.publish(Mockito.<PublishRequest>any())).thenReturn(publishResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSNS).publish(isA(PublishRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSnsNodeConfiguration).getTopicArnPattern();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link AmazonSNS#publish(PublishRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls publish(PublishRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsPublish() {
    // Arrange
    when(tbSnsNodeConfiguration.getTopicArnPattern()).thenReturn("Topic Arn Pattern");

    PublishResult publishResult = new PublishResult();
    publishResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSNS.publish(Mockito.<PublishRequest>any())).thenReturn(publishResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSNS).publish(isA(PublishRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSnsNodeConfiguration).getTopicArnPattern();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(tbSnsNodeConfiguration.getTopicArnPattern()).thenReturn("Topic Arn Pattern");

    PublishResult publishResult = new PublishResult();
    publishResult.setSdkResponseMetadata(new ResponseMetadata(new HashMap<>()));
    when(amazonSNS.publish(Mockito.<PublishRequest>any())).thenReturn(publishResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(amazonSNS).publish(isA(PublishRequest.class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbSnsNodeConfiguration).getTopicArnPattern();
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
