package org.thingsboard.rule.engine.kafka;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbKafkaNodeDiffblueTest {
  @Mock private Producer<String, String> producer;

  @InjectMocks private TbKafkaNode tbKafkaNode;

  @Mock private TbKafkaNodeConfiguration tbKafkaNodeConfiguration;

  @Mock private Throwable throwable;

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsGetServiceId() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenThrow(new RuntimeException());
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getSelfId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbContext getSelfId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbContextGetSelfIdThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenThrow(new RuntimeException());
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNodeConfiguration} {@link TbKafkaNodeConfiguration#getKeyPattern()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbKafkaNodeConfiguration getKeyPattern() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbKafkaNodeConfigurationGetKeyPatternThrowRuntimeException() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenThrow(new RuntimeException());
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.onMsg(ctx, msg));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNodeConfiguration} {@link TbKafkaNodeConfiguration#getTopicPattern()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbKafkaNodeConfiguration getTopicPattern() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbKafkaNodeConfigurationGetTopicPatternThrowRuntimeException() {
    // Arrange
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenThrow(new RuntimeException());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.onMsg(ctx, msg));
    verify(tbKafkaNodeConfiguration).getTopicPattern();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link Throwable#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsGetMessage() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenReturn("Key Pattern");
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("$[UU]");
    when(throwable.getMessage()).thenReturn("Not all who wander are lost");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbKafkaNode.onMsg(ctx, msg);

    // Assert
    verify(throwable).getMessage();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link Throwable#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsGetMessage() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenReturn("Key Pattern");
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    when(throwable.getMessage()).thenReturn("Not all who wander are lost");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbKafkaNode.onMsg(ctx, msg);

    // Assert
    verify(throwable).getMessage();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Producer} {@link Producer#send(ProducerRecord, Callback)} return {@link
   *       CompletableFuture#CompletableFuture()}.
   *   <li>Then calls {@link Producer#send(ProducerRecord, Callback)}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given Producer send(ProducerRecord, Callback) return CompletableFuture(); then calls send(ProducerRecord, Callback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenProducerSendReturnCompletableFuture_thenCallsSend() {
    // Arrange
    when(producer.send(Mockito.<ProducerRecord<String, String>>any(), Mockito.<Callback>any()))
        .thenReturn(new CompletableFuture<>());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbKafkaNode.publish(ctx, msg, "Topic", "Key");

    // Assert
    verify(producer).send(isA(ProducerRecord.class), isA(Callback.class));
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNode} (default constructor).
   *   <li>Then calls {@link TbContext#getSelfId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given TbKafkaNode (default constructor); then calls getSelfId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenTbKafkaNode_thenCallsGetSelfId() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbKafkaNode.publish(ctx, msg, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNode} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#getSelfId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given TbKafkaNode (default constructor); when 'null'; then calls getSelfId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenTbKafkaNode_whenNull_thenCallsGetSelfId() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbKafkaNode.publish(ctx, null, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Producer} {@link Producer#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Producer close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.destroy()"})
  void testDestroy_givenProducerCloseDoesNothing() {
    // Arrange
    doNothing().when(producer).close();

    // Act
    tbKafkaNode.destroy();

    // Assert
    verify(producer).close();
  }

  /**
   * Test {@link TbKafkaNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Producer} {@link Producer#close()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Producer close() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.destroy()"})
  void testDestroy_givenProducerCloseThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(producer).close();

    // Act
    tbKafkaNode.destroy();

    // Assert
    verify(producer).close();
  }
}
